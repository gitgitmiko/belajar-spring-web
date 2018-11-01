package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.FakultasDAO;
import com.flashdin.belajarspringweb.entity.Fakultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class FakultasDAOImpl implements FakultasDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Fakultas save(Fakultas param) {
        String sql = "insert into table_fakultas (nama) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());

            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Fakultas update(Fakultas param) {
        String sql = "update table_fakultas set  nama=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setInt(2, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Fakultas param) {
        String sql = "delete from table_fakultas where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Fakultas findById(int id) {
        String sql = "select * from table_fakultas where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Fakultas.class));
    }

    @Override
    public List<Fakultas> findAll() {
        String sql = "select * from table_fakultas";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fakultas.class));
    }

    @Override
    public List<Fakultas> findByName(Fakultas param) {
        String sql = "select * from table_fakultas where makul like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNama() + "%"}, new BeanPropertyRowMapper<>(Fakultas.class));
    }

}