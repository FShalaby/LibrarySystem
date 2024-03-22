package sandbox;

import java.util.ArrayList;
import java.util.List;

public class CategoryStrategy extends Item implements BookStrategy {
  List<Item> recommendations = new ArrayList<>();

  @Override
  public List<Item> search(String query) {
    List<Item> items = Database.getInstance().getAllItems();

    for (Item item : items) {
      if (item.category.equalsIgnoreCase(query)) {
        recommendations.add(item);
      }
    }

    return recommendations;
  }
}
