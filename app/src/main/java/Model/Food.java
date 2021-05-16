package Model;

public class Food {
    private String Name, Img,Price,MenuId;

    public Food(String name, String img, String price, String menuId) {
        Name = name;
        Img = img;
        Price = price;
        MenuId = menuId;
    }

    public Food() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
