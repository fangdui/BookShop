package com.tp.service;

import com.tp.dao.Basedao;
import com.tp.entity.TP_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TP_USERDao {
    public static int insert(TP_USER u){
        String sql = "insert into tp_user values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";

        Object[] params = {
                u.getUser_id(),
                u.getUser_name(),
                u.getUser_password(),
                u.getUser_sex(),
                u.getUser_birthday(),
                u.getUser_identity_code(),
                u.getUser_email(),
                u.getUser_mobile(),
                u.getUser_address(),
                u.getUser_status()};

        return Basedao.exectuIUD(sql,params);
    }

    public static int del(String id){
        String sql = "delete from tp_user where user_id=? and user_status!=2";
        Object[] params = {id};
        return Basedao.exectuIUD(sql,params);
    }

    public static int update(TP_USER u){
        String sql = "update tp_user set user_name=?,user_password=?,user_sex=?,user_birthday=DATE_FORMAT(?,'%Y-%m-%d'),user_identity_code=?,user_email=?,user_mobile=?,user_address=?,user_status=? where user_id=?";

        Object[] params = {
                u.getUser_name(),
                u.getUser_password(),
                u.getUser_sex(),
                u.getUser_birthday(),
                u.getUser_identity_code(),
                u.getUser_email(),
                u.getUser_mobile(),
                u.getUser_address(),
                u.getUser_status(),
                u.getUser_id()};

        return Basedao.exectuIUD(sql,params);
    }

    public static int selectByName(String id){
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select count(*) from tp_user where user_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
               count = rs.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return count;
    }

    //获取总记录数和总页数
    public static int[] totalPage(int count,String keyword){
        //0总记录数 1总页数
        int arr[] = {0,1};

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "";
            if(keyword!=null){
                sql = "select count(*) from tp_user where user_name like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
            }else {
                sql = "select count(*) from tp_user";
                ps = conn.prepareStatement(sql);
            }

            rs = ps.executeQuery();
            while (rs.next()){
                arr[0] = rs.getInt(1);
                if(arr[0]%count==0){
                    arr[1] = arr[0]/count;
                }else {
                    arr[1] = arr[0]/count+1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return arr;
    }

    public static ArrayList<TP_USER> selectAll(int cpage,int count,String keyword){
        ArrayList<TP_USER> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "";

            if(keyword !=null){
                sql = "select * from tp_user where user_name like ? order by user_birthday desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
                ps.setInt(2,(cpage-1)*count);
                ps.setInt(3,count);
            }else {
                sql = "select * from tp_user order by user_birthday desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,(cpage-1)*count);
                ps.setInt(2,count);
            }

            rs = ps.executeQuery();
            while (rs.next()){
                TP_USER u = new TP_USER(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("user_sex"),
                        rs.getString("user_birthday"),
                        rs.getString("user_identity_code"),
                        rs.getString("user_email"),
                        rs.getString("user_mobile"),
                        rs.getString("user_address"),
                        rs.getInt("user_status")
                );
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static TP_USER selectById(String id){
        TP_USER u = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select t.*,DATE_FORMAT(t.user_birthday,'%Y-%m-%d') birthday from tp_user t where user_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1,id);

            rs = ps.executeQuery();
            while (rs.next()){
                u = new TP_USER(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("user_sex"),
                        rs.getString("birthday"),
                        rs.getString("user_identity_code"),
                        rs.getString("user_email"),
                        rs.getString("user_mobile"),
                        rs.getString("user_address"),
                        rs.getInt("user_status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return u;
    }

    public static int selectByNM(String name,String pwd){
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select count(*) from tp_user where user_id=? and user_password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return count;
    }

    //通过用户名和密码查询用户信息
    public static TP_USER selectAdmin(String name,String pwd){
        TP_USER u = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select t.*,DATE_FORMAT(t.user_birthday,'%Y-%m-%d') birthday from tp_user t where user_id = ?and user_password=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);

            rs = ps.executeQuery();
            while (rs.next()){
                u = new TP_USER(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("user_sex"),
                        rs.getString("birthday"),
                        rs.getString("user_identity_code"),
                        rs.getString("user_email"),
                        rs.getString("user_mobile"),
                        rs.getString("user_address"),
                        rs.getInt("user_status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return u;
    }
}
