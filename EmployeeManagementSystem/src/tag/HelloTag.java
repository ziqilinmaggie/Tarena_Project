package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 1,继承SimpleTagSupport类
 * 2,override doTag方法
 * 3,标签有哪些属性，标签类也要有对应的属性（属性名一样，类型一致，并有相应set方法）
 * 4,doTag方法里面，经常使用getJspContext来获得pageContext。
 *
 */
public class HelloTag extends SimpleTagSupport {
	private String info;
	private int qty;
	public HelloTag(){
		System.out.println("HelloTag's constructor...");
	}

	public void setInfo(String info) {
		System.out.println("setInfo..."+info);
		this.info = info;
	}

	public void setQty(int qty) {
		System.out.println("setqut..."+qty);
		this.qty = qty;
	}
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag...");
		//pageContext一个jsp对应一个上下文
		//通过SimpleTagSupport提供的方法来获得pageContext
		PageContext pctx = (PageContext)getJspContext();
		//pageContext提供了几个方法用来获得其他所有隐含对象
		JspWriter out = pctx.getOut();
		
		for(int i =0;i<qty;i++){
			out.println(info+"<br/>");
		}
	}
	
}
