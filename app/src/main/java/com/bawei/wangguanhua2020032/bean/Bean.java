package com.bawei.wangguanhua2020032.bean;

import java.util.List;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 */
public class Bean {


    private String code;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<HorizontalListDataBean> horizontalListData;
        private List<VerticalListDataBean> verticalListData;
        private List<GridDataBean> gridData;

        public List<HorizontalListDataBean> getHorizontalListData() {
            return horizontalListData;
        }

        public void setHorizontalListData(List<HorizontalListDataBean> horizontalListData) {
            this.horizontalListData = horizontalListData;
        }

        public List<VerticalListDataBean> getVerticalListData() {
            return verticalListData;
        }

        public void setVerticalListData(List<VerticalListDataBean> verticalListData) {
            this.verticalListData = verticalListData;
        }

        public List<GridDataBean> getGridData() {
            return gridData;
        }

        public void setGridData(List<GridDataBean> gridData) {
            this.gridData = gridData;
        }

        public static class HorizontalListDataBean {


            private String imageurl;

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }

        public static class VerticalListDataBean {


            private String title;
            private String price;
            private String imageurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }

        public static class GridDataBean {

            private String title;
            private String price;
            private String imageurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }
    }
}
