import java.util.List;

import org.junit.Test;

import com.clps.demo.dao.impl.CategoryDaoImpl;
import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;

public class TestDao {
	@Test
	public void testCategoryDao() {
		CategoryDaoImpl c = new CategoryDaoImpl();
		 List<Item> itemlist = c.queryItem("FI-FW-01");
		 
		System.out.println(itemlist.get(0).getItemid());
	}
}
