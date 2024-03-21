package sandbox;

public class ReturnItemCommand implements  Command{

    private Item item;
    private User user;
    public ReturnItemCommand(Item item, User user) {
        this.item = item;
        this.user=user;
    }

    @Override
    public void execute() {
        LibrarySystem.inventory.put(item.name, item.copies+1);
        Database.deleteRental(this.item.id,this.user.id);
        Database.updateItemCopies(this.item.id, 1);
    }
}
