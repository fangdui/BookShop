package com.tp.service;

import com.tp.dao.Basedao;
import com.tp.entity.TP_PRODUCT;
import com.tp.entity.TP_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TP_PRODUCTDao {
    public static int insert(TP_PRODUCT product){
        String sql = "insert into tp_product values(null,?,?,?,?,?,?,?)";

        Object[] params = {
                product.getProduct_name(),
                product.getProduct_description(),
                product.getProduct_price(),
                product.getProduct_stock(),
                product.getProduct_fid(),
                product.getProduct_cid(),
                product.getProduct_filename()
        };
        return Basedao.exectuIUD(sql,params);
    }

    public static int update(TP_PRODUCT p){
        String sql = "update tp_product set product_name=?,product_description=?,product_price=?,product_stock=?,product_fid=?,product_cid=?,product_filename=? where product_id=?";

        Object[] params = {
                p.getProduct_name(),
                p.getProduct_description(),
                p.getProduct_price(),
                p.getProduct_stock(),
                p.getProduct_fid(),
                p.getProduct_cid(),
                p.getProduct_filename(),
                p.getProduct_id()};

        return Basedao.exectuIUD(sql,params);
    }

    public static int del(String id){
        String sql = "delete from tp_product where product_id=?";
        Object[] params = {id};
        return Basedao.exectuIUD(sql,params);
    }

    public static ArrayList<TP_PRODUCT> selectAll(){
        ArrayList<TP_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_product";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_PRODUCT product = new TP_PRODUCT(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<TP_PRODUCT> selectByName(String name){
        ArrayList<TP_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_product where product_name like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();

            while (rs.next()){
                TP_PRODUCT product = new TP_PRODUCT(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<TP_PRODUCT> selectLastFour(){
        ArrayList<TP_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_product order by product_id desc limit 4 ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_PRODUCT product = new TP_PRODUCT(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<TP_PRODUCT> selectByAllFid(int fid){
        ArrayList<TP_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_product where product_fid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,fid);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_PRODUCT product = new TP_PRODUCT(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<TP_PRODUCT> selectByAllCid(int cid){
        ArrayList<TP_PRODUCT> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_product where product_cid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_PRODUCT product = new TP_PRODUCT(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static TP_PRODUCT selectById(int id){
        TP_PRODUCT p = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_product where product_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()){
                 p = new TP_PRODUCT(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return p;
    }

    public static ArrayList<TP_PRODUCT> selectAllById(ArrayList<Integer> ids){
        ArrayList<TP_PRODUCT> lastList = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            for(int i=0;i<ids.size();i++){
                String sql = "select * from tp_product where product_id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,ids.get(i));
                rs = ps.executeQuery();

                while (rs.next()){
                     TP_PRODUCT p  = new TP_PRODUCT(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getString("product_description"),
                            rs.getInt("product_price"),
                            rs.getInt("product_stock"),
                            rs.getInt("product_fid"),
                            rs.getInt("product_cid"),
                            rs.getString("product_filename")
                    );
                    lastList.add(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return lastList;
    }
}
