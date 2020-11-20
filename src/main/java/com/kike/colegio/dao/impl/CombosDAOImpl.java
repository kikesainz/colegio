package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.utils.DBUtils;

public class CombosDAOImpl implements CombosDAO{

	@Override
	public List<ComboDTO> comboMunicipios() {
		
		String sql = "SELECT * FROM municipios ORDER BY nombre";
		List<ComboDTO> listaMunicipios = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			 
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			
			while (rs.next()) {				
				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(5));
				listaMunicipios.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return listaMunicipios;
	}

}
