package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.constant.Table;
import com.flashdin.belajarspringweb.dao.MahasiswaDAO;
import com.flashdin.belajarspringweb.entity.Fakultas;
import com.flashdin.belajarspringweb.entity.Jurusan;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Mahasiswa> find() {
        String sql = "SELECT " +
                "mahasiswa.id AS id, " +
                "mahasiswa.namaMhs AS namaMhs, " +
                "mahasiswa.alamat AS alamat, " +
                "jurusan.id AS idJurusan, " +
                "jurusan.nama AS namaJurusan, " +
                "fakultas.id AS idFakultas, " +
                "fakultas.nama AS namaFakultas " +
                "FROM " + Table.TABLE_MAHASISWA + " mahasiswa INNER JOIN " + Table.TABLE_JURUSAN +
                " jurusan ON jurusan.id = mahasiswa.idJurusan " +
                "INNER JOIN  " + Table.TABLE_FAKULTAS + " fakultas ON fakultas.id = jurusan.idFakultas ";
        //ganti imi
        return jdbcTemplate.query(sql, new RowMapper<Mahasiswa>() {
            @Override
            public Mahasiswa mapRow(ResultSet rs, int rowNum) throws SQLException {

                Mahasiswa mahasiswa=new Mahasiswa();
                mahasiswa.setId(rs.getInt("id"));
                mahasiswa.setNamaMhs(rs.getString("namaMhs"));
                mahasiswa.setAlamat(rs.getString("alamat"));
                mahasiswa.setIdFakultas(rs.getInt("idFakultas"));
                mahasiswa.setIdJurusan(rs.getInt("idJurusan"));

                Jurusan jurusan=new Jurusan();
                jurusan.setId(rs.getInt("idJurusan")); //nama_fakultas
                jurusan.setNama(rs.getString("namaJurusan"));
                jurusan.setIdFakultas(rs.getInt("idFakultas"));

                Fakultas fakultas=new Fakultas();
                fakultas.setId(rs.getInt("idFakultas"));
                fakultas.setNama(rs.getString("namaFakultas"));

                mahasiswa.setFakultas(fakultas);
                mahasiswa.setJurusan(jurusan);

                return mahasiswa;

            }
        });//sampe sini
    }

    @Override
    public Mahasiswa save(Mahasiswa param) {
        String sql = "insert into table_students (namaMhs,alamat, idFakultas, idJurusan) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNamaMhs());
            ps.setString(2, param.getAlamat());
            ps.setInt(3, param.getIdFakultas());
            ps.setInt(4, param.getIdJurusan());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        String sql = "update table_students set namaMhs=?,alamat=?, idFakultas=?, idJurusan=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNamaMhs());
            ps.setString(2, param.getAlamat());
            ps.setInt(3, param.getIdFakultas());
            ps.setInt(4, param.getIdJurusan());
            ps.setInt(5, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Mahasiswa param) {
        String sql = "delete from table_students where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Mahasiswa findById(int id) {
        String sql = "select * from table_students where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public List<Mahasiswa> findAll() {
        String sql = "select * from table_students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }


    @Override
    public List<Mahasiswa> findByName(Mahasiswa param) {
        String sql = "select * from table_students where namaMhs like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNamaMhs() + "%"}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }



}