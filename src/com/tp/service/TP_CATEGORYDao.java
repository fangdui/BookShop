package com.tp.service;

import com.tp.dao.Basedao;
import com.tp.entity.TP_CATEGORY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TP_CATEGORYDao {
    //获取分类
    public static ArrayList<TP_CATEGORY> selectAll(){
        ArrayList<TP_CATEGORY> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_category";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_CATEGORY cate = new TP_CATEGORY(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );
                list.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    /**
     * 查询子分类和父分类
     * @param flag="father"  flag="child"
     * @return
     */
    public static ArrayList<TP_CATEGORY> selectCate(String flag){
        ArrayList<TP_CATEGORY> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = null;
            if(flag != null && flag.equals("father")){
                sql = "select * from tp_category where cate_parent_id = 0";
            }else{
                sql = "select * from tp_category where cate_parent_id != 0";
            }
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                TP_CATEGORY cate = new TP_CATEGORY(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );
                list.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static TP_CATEGORY selectById(int id){
        TP_CATEGORY cate = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from tp_category where cate_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            while (rs.next()){
                cate = new TP_CATEGORY(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return cate;
    }

    public static int insert(TP_CATEGORY cate){
        String sql = "insert into tp_category values(null,?,?)";

        Object[] params = {
                cate.getCate_name(),
                cate.getCate_parent_id()
        };
        return Basedao.exectuIUD(sql,params);
    }

    public static int update(TP_CATEGORY cate){
        String sql = "update tp_category set cate_name=?,cate_parent_id=? where cate_id=?";

        Object[] params = {
                cate.getCate_name(),
                cate.getCate_parent_id(),
                cate.getCate_id()
        };

        return Basedao.exectuIUD(sql,params);
    }

    public static int del(int id){
        String sql = "delete from tp_category where cate_id=?";

        Object[] params = {id};
        return Basedao.exectuIUD(sql,params);
    }

}
