package cart.data;

import java.util.*;

public class localCache {
    private static Map<Long, product> map = new HashMap<Long, product>();

    private static Map<Long, cart> cartMap = new HashMap<Long, cart>();

    private static Map<Long, product> favoriteMap = new HashMap<Long, product>();

    private static Map<Long, product> browseMap = new HashMap<Long, product>();

    static {
        map.put(1l, new product(1l, "美少女", "雯雯", "喜欢吃", "中级", 1));
        map.put(2l, new product(2l, "美少女", "涵涵", "喜欢吃", "中级", 1));
        map.put(3l, new product(3l, "美少女", "紫紫", "喜欢吃", "中级", 1));
        map.put(4l, new product(4l, "美少女", "恬恬", "喜欢吃", "中级", 1));
        map.put(5l, new product(5l, "美少女", "珠珠", "喜欢吃", "中级", 1));
        map.put(6l, new product(6l, "美少女", "莉莉", "喜欢吃", "中级", 1));
        map.put(7l, new product(7l, "美少女", "佳佳", "喜欢吃", "中级", 1));
        map.put(8l, new product(8l, "美少女", "奥奥", "喜欢吃", "中级", 1));
        map.put(9l, new product(9l, "美少女", "荣荣", "喜欢吃", "中级", 1));
        map.put(10l, new product(10l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(11l, new product(11l, "美少女", "婷婷", "喜欢吃", "中级", 1));
        map.put(12l, new product(12l, "美少女", "娴娴", "喜欢吃", "中级", 1));
        map.put(13l, new product(13l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(14l, new product(14l, "美少女", "栗栗", "喜欢吃", "中级", 1));
        map.put(15l, new product(15l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(16l, new product(16l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(17l, new product(17l, "美少女", "莉莉", "喜欢吃", "中级", 1));
        map.put(18l, new product(18l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(19l, new product(19l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(20l, new product(20l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(21l, new product(21l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(22l, new product(22l, "美少女", "雯雯", "喜欢吃", "中级", 1));
        map.put(23l, new product(23l, "美少女", "涵涵", "喜欢吃", "中级", 1));
        map.put(24l, new product(24l, "美少女", "紫紫", "喜欢吃", "中级", 1));
        map.put(25l, new product(25l, "美少女", "恬恬", "喜欢吃", "中级", 1));
        map.put(26l, new product(26l, "美少女", "珠珠", "喜欢吃", "中级", 1));
        map.put(27l, new product(27l, "美少女", "莉莉", "喜欢吃", "中级", 1));
        map.put(28l, new product(28l, "美少女", "佳佳", "喜欢吃", "中级", 1));
        map.put(29l, new product(29l, "美少女", "奥奥", "喜欢吃", "中级", 1));
        map.put(30l, new product(30l, "美少女", "荣荣", "喜欢吃", "中级", 1));
        map.put(31l, new product(31l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(32l, new product(32l, "美少女", "婷婷", "喜欢吃", "中级", 1));
        map.put(33l, new product(33l, "美少女", "娴娴", "喜欢吃", "中级", 1));
        map.put(34l, new product(34l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(35l, new product(35l, "美少女", "栗栗", "喜欢吃", "中级", 1));
        map.put(36l, new product(36l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(37l, new product(37l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(38l, new product(38l, "美少女", "莉莉", "喜欢吃", "中级", 1));
        map.put(39l, new product(39l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(40l, new product(40l, "美少女", "璇璇", "喜欢吃", "中级", 1));
        map.put(41l, new product(41l, "美少女", "龙龙", "喜欢吃", "中级", 1));
        map.put(42l, new product(42l, "美少女", "龙龙", "喜欢吃", "中级", 1));
    }

    public static List<product> getProducts() {
        return new ArrayList<>(map.values());
    }

    public static List<product> getProducts(int page,int size,String name) {
        List<product> products = addProducts(name);

        int start = (page - 1) * size;
        int end = products.size()>=page*size?page*size:products.size();//注意等号

        return products.subList(start, end);
    }

    public static int getProductsCount(String name) {
        List<product> products = addProducts(name);
        return products.size();
    }

    private static List<product> addProducts(String name) {
        List<product> products = new ArrayList<>();
        if (null != name && !"".equals(name)) {
            map.values().forEach(product -> {
                if (product.getName().contains(name)) {//就是name属性中包含字符就加入
                    products.add(product);
                }
            });
        } else {
            products.addAll(map.values());
        }
        return products;
    }


    public static List<product> getFavorites() {
        return new ArrayList<>(favoriteMap.values());
    }

    public static List<product> getBrowseLogs() {
        return new ArrayList<>(browseMap.values());
    }

    public static List<cart> getCarts() {
        return new ArrayList<>(cartMap.values());
    }

    public static product getProduct(Long id) {
        return map.get(id);
    }

    public static product getFavorite(Long id) {
        return favoriteMap.get(id);
    }

    public static cart getCart(Long id) {
        return cartMap.get(id);
    }

    public static void addCart(product product) {
        if (!cartMap.containsKey(product.getId())) {
            cartMap.put(product.getId(), new cart(product.getId(), product.getId(), product.getName(), product.getPrice(), 1, product.getPrice()));
        } else {
            incrCart(product.getId());
        }
    }

    public static void addBrowseLog(product product) {
        if (!browseMap.containsKey(product.getId())) {
            browseMap.put(product.getId(), product);
        }
    }

    public static void addFavorite(product product) {
        if (!cartMap.containsKey(product.getId()))
            favoriteMap.put(product.getId(), product);
    }

    public static void incrCart(Long productId) {
        cartMap.get(productId).incCart();
    }

    public static void decrCart(Long productId) {
        boolean flag = cartMap.get(productId).delCart();
        if (!flag) {
            delCart(productId);
        }
    }

    public static void delFavorite(Long productId) {
        favoriteMap.remove(productId);
    }

    public static void delCart(Long productId) {
        cartMap.remove(productId);
    }

    public static void delBrowseLog(Long productId) {
        browseMap.remove(productId);
    }

}
