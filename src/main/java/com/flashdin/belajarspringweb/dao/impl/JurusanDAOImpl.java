package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.JurusanDAO;
import com.flashdin.belajarspringweb.entity.Jurusan;
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
public class JurusanDAOImpl implements JurusanDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Jurusan save(Jurusan param) {
        String sql = "insert into table_jurusan (nama,idFakultas) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setInt(2, param.getIdFakultas());

            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Jurusan update(Jurusan param) {
        String sql = "update table_jurusan set  nama=?, idFakultas=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setInt(1, param.getIdFakultas());
            ps.setInt(2, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Jurusan param) {
        String sql = "delete from table_jurusan where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Jurusan findById(int id) {
        String sql = "select * from table_jurusan where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Jurusan.class));
    }

    @Override
    public List<Jurusan> findAll() {
        String sql = "select * from table_jurusan";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Jurusan.class));
    }

    @Override
    public List<Jurusan> findByName(Jurusan param) {
        String sql = "select * from table_jurusan where jurusan like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNama() + "%"}, new BeanPropertyRowMapper<>(Jurusan.class));
    }

}