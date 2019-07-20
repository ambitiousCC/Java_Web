package cart.servlet;

import cart.data.localCache;
import cart.data.product;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageStr = request.getParameter("page");//向后台传入的数据，由于第一页是1，所以相当于初始化了
        String name = request.getParameter("title");//input的属性是name，这里获得的是输入的文字
        int page = 1;
        if (null != pageStr && !"".equals(pageStr)) {
            page = Integer.valueOf(pageStr);
        }

        int totalProducts = localCache.getProductsCount(name);

        List<product> products1 = localCache.getProducts(page, 12,name);

        int totalPage = totalProducts % 12 > 0 ? totalProducts / 12 + 1 : totalProducts / 12;

        int prePage = page <= 1 ? 1 : page - 1;
        int nextPage = totalPage > page ? page + 1 : totalPage;

        request.setAttribute("curPage",page);
        request.setAttribute("prePage", prePage);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("title",name);

        request.setAttribute("products",products1);

        request.getRequestDispatcher("/WEB-INF/views/biz/list.jsp").forward(request,response);

    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
