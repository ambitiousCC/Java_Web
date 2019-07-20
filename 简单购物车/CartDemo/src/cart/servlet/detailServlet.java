package cart.servlet;

import cart.data.localCache;
import cart.data.product;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class detailServlet extends HttpServlet {

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
        if (Objects.equals("/detail/detail.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (null != productId) {
                product product = localCache.getProduct(Long.valueOf(productId));
                req.setAttribute("product",product);
                localCache.addBrowseLog(product);
                System.out.println("test:" + localCache.getBrowseLogs().toString());
            }
            req.getRequestDispatcher("/WEB-INF/views/biz/detail.jsp").forward(req,resp);
        }
    }
}
