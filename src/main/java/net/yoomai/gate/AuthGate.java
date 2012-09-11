package net.yoomai.gate;

import javax.servlet.http.HttpServlet;

/**
 * @(#)AuthGate.java 1.0 11/09/2012
 * <p/>
 * 这是一个用户信息验证的入口
 * 当用户被客户端重定向到这个地址的时候，需要对cookie进行检测，看是否存在一个相关的TGT票据信息
 * 如果不存在，则进行登录验证；如果存在，则对请求的ST进行生成
 */
public class AuthGate extends HttpServlet {

}
