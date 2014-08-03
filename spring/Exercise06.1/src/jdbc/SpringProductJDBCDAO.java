package jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class SpringProductJDBCDAO implements IProductDAO {
	private DataSource dataSource;

    public void save(Product product) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("number", product.getProductnumber());
    	namedParameters.put("name", product.getProductName());
    	namedParameters.put("price", product.getPrice());
    	
    	@SuppressWarnings("unused")
		int updateResult = jdbcTempl.update("INSERT INTO product VALUES(:number,:name,:price)", namedParameters);
    }

    public void update(Product product) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("number", product.getProductnumber());
    	namedParameters.put("name", product.getProductName());
    	namedParameters.put("price", product.getPrice());
    	
    	@SuppressWarnings("unused")
		int updateResult = jdbcTempl.update("UPDATE product SET name=:name, price=:price  WHERE number=:number",namedParameters);
    }

    public Product load(int productNumber) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("number", productNumber);
        Product product = jdbcTempl.queryForObject("SELECT * FROM Product WHERE number =:number ", namedParameters, 
        		new RowMapper<Product>(){
					public Product mapRow(ResultSet resultSet, int i) throws SQLException {
						return new Product(resultSet.getInt("number"),resultSet.getString("name"),resultSet.getDouble("price"));
					}
        		}
        );
        return product;
    }

    public void delete(Product product) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("number", product.getProductnumber());

    	@SuppressWarnings("unused")
		int updateResult = jdbcTempl.update("DELETE FROM product WHERE number =:number",namedParameters);
    }

    public Collection<Product> getAllProducts() {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Product> namedParameters = new HashMap<String, Product>();
        List<Product> productlist = jdbcTempl.query("SELECT * FROM Product",
        		namedParameters, 
        		new RowMapper<Product>(){
					public Product mapRow(ResultSet resultSet, int i) throws SQLException {
						return new Product(resultSet.getInt("number"),
								resultSet.getString("name"),
								resultSet.getDouble("price"));
					}
        });
        return productlist;
     }

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
