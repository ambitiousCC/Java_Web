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

public class browseLogServlet extends HttpServlet {
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
        if (Objects.equals("/browse/list.do", req.getServletPath())) {
                req.setAttribute("products",localCache.getBrowseLogs());
                req.getRequestDispatcher("/WEB-INF/views/biz/browse_list.jsp").forward(req,resp);
        } else if (Objects.equals("/browse/delete.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (null != productId) {
                localCache.delBrowseLog(Long.valueOf(productId));
            }
            resp.sendRedirect("/browse/list.do");
        }
    }
}
