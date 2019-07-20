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

public class cartServlet extends HttpServlet {

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/cart/cart.do", req.getServletPath())) {
            String productId = req.getParameter("productId");//这里出错！！！！！
            if (null != productId) {
                product product = localCache.getProduct(Long.valueOf(productId));
                localCache.addCart(product);
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/delete.do", req.getServletPath())) {
            String productId = req.getParameter("productId");//这里出错！！！！！
            if (null != productId) {
                localCache.delCart(Long.valueOf(productId));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/decr.do", req.getServletPath())) {
            String productId = req.getParameter("productId");//这里出错！！！！！
            //减少
            if (null != productId) {
                localCache.decrCart(Long.valueOf(productId));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/incr.do", req.getServletPath())) {
            String productId = req.getParameter("productId");//这里出错！！！！！
            if (null != productId) {
                localCache.incrCart(Long.valueOf(productId));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/list.do", req.getServletPath())) {
            req.setAttribute("carts", localCache.getCarts());
            req.getRequestDispatcher("/WEB-INF/views/biz/cart.jsp").forward(req, resp);
        } else if (Objects.equals("/cart/settlement.do", req.getServletPath())) {
            String[] cartIds = req.getParameterValues("carts");
            int totalCount = 0;
            for (int i = 0; i < cartIds.length; i++) {
                cart cart = localCache.getCart(Long.valueOf(cartIds[i]));
                totalCount += cart.getPrice();
                localCache.delCart(cart.getId());
            }
            req.setAttribute("totalPrice",totalCount);
            req.getRequestDispatcher("/WEB-INF/views/biz/settlement.jsp").forward(req,resp);
        }
    }

}
