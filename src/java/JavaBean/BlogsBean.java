/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaBean;

import java.util.ArrayList;

public class BlogsBean {
    
    private ArrayList<BlogBean> allBlogs = new ArrayList<BlogBean>();

    public BlogsBean() {
    }

    public ArrayList<BlogBean> getBlogs() {
        return allBlogs;
    }

    public void setBlogs(ArrayList<BlogBean> allBlogs) {
        this.allBlogs= allBlogs;
    }

    @Override
    public String toString() {
        return "BlogsBean{" + "allBlogs=" + allBlogs + '}';
    }
}
