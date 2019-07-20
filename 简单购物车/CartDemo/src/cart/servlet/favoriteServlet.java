package cart.servlet;

import cart.data.localCache;
import cart.data.product;
import cart.data.cart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class favoriteServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/favorite/favorite.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (null != productId) {
                product product = localCache.getProduct(Long.valueOf(productId));
                localCache.addFavorite(product);
            }
            resp.sendRedirect("/favorite/list.do");
        } else if (Objects.equals("/favorite/delete.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if(null!=productId) {
                localCache.delFavorite(Long.valueOf(productId));
            }
            resp.sendRedirect("/favorite/list.do");
        } else if (Objects.equals("/favorite/list.do", req.getServletPath())) {
            req.setAttribute("products",localCache.getFavorites());
            req.getRequestDispatcher("/WEB-INF/views/biz/favorite.jsp").forward(req,resp);
        }
    }

}
