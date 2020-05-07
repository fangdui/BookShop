package com.tp.service;

import com.tp.dao.Basedao;
import com.tp.entity.TP_CART;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TP_CARTDao {
    public static int insert(TP_CART cart){
        String sql = "insert into tp_cart values(null,?,?,?,?,?,?,?,1)";
        Object[] params = {
                cart.getCart_p_filename(),
                cart.getCart_p_name(),
                cart.getCart_p_price(),
                cart.getCart_quantity(),
                cart.getCart_p_stock(),
                cart.getCart_p_id(),
                cart.getCart_u_id()
        };
        return Basedao.exectuIUD(sql,params);
    }

    public static TP_CART getCartShop(String id){
        TP_CART cart = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_cart where cart_id=? and cart_valid=1 order by cart_id desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();

            while (rs.next()){
                cart = new TP_CART(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_quantity"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return cart;
    }

    public static TP_CART getCartShop(String uid,String pid){
        TP_CART cart = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_cart where cart_u_id=? and cart_p_id=? and cart_valid=1 order by cart_id desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uid);
            ps.setInt(2,(Integer.parseInt(pid)));
            rs = ps.executeQuery();

            while (rs.next()){
                 cart = new TP_CART(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_quantity"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return cart;
    }

    public static ArrayList<TP_CART> getCart(String uid){
        ArrayList<TP_CART> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_cart where cart_u_id=? and cart_valid=1 order by cart_id desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uid);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_CART c = new TP_CART(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_quantity"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static int updatenum(int cartid,int count){
        String sql = "update tp_cart set cart_quantity=? where cart_id=?";
        Object[] params = {count,cartid};
        return Basedao.exectuIUD(sql,params);
    }

    public static int getDeleteDD(int cartid){
        String sql = "delete from tp_cart where cart_id=?";
        Object[] params = {cartid};
        return Basedao.exectuIUD(sql,params);
    }
}
