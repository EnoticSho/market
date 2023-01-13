package gb.ru.market.api;

public class ProductDto {
    private Long id;
    private String name;
    private int price;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, int price, String categoryTitle) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryTitle = categoryTitle;
    }

    private String categoryTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
