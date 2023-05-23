package com.example.dao.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.Model.student.Student;

public class StudentDataAccessRepository extends AbstractDataAccessRepository<Student> {

    String query;
    ResultSet rs;
    PreparedStatement pstm;
    int i;

    @Override
    public int save(Student student) {
        query = "INSERT INTO students (name, email, active) values(?,?,?)";
        try {
            connect();
            pstm = con.prepareStatement(query);
            pstm.setString(1, student.getName());
            pstm.setString(2, student.getEmail());
            pstm.setBoolean(3, student.isActive());
            i = pstm.executeUpdate();
            disconnect();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Student getOne(int id) {
        query = "SELECT * FROM students WHERE id=?";
        try {
            connect();
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Student st = new Student();
            if (rs.next()) {
                st.setId(rs.getInt("id"));
                st.setEmail(rs.getString("email"));
                st.setName(rs.getString("name"));
                st.setActive(rs.getBoolean("active"));
                disconnect();
                return st;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ArrayList<Student> getAll() {
        query = "SELECT * FROM students";
        try {
            connect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setEmail(rs.getString("email"));
                st.setName(rs.getString("name"));
                st.setActive(rs.getBoolean("active"));
                students.add(st);
            }
            disconnect();
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int update(Student t) {
        query = "UPDATE students set name=?, email=?, active=? WHERE id=?";
        connect();
        try {
            pstm = con.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setString(2, t.getEmail());
            pstm.setBoolean(3, t.isActive());
            pstm.setInt(4, t.getId());
            i = pstm.executeUpdate();
            disconnect();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int delete(int id) {
        query = "DELETE FROM students where id=?";
        connect();
        try {
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            i = pstm.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

}
