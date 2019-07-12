$(function () {
    var listUrl = '/o2o/shopadmin/getproductcategorylist';
    var addUrl = '/o2o/shopadmin/addproductcategorys';
    var deleteUrl = '/o2o/shopadmin/removeproductcategory';
    getList();

    function getList() {
        $.getJSON(listUrl, function (data) {
            if (data.success) {
                var dataList = data.data;
                $('.category-wrap').html('');
                var tempHtml = '';
                dataList.map(function (index, value) {
                    tempHtml += ''
                        + '<div class="row row-product-category now">'
                        + '<div class="col-33 product-category-name">'
                        + index.productCategoryName
                        + '</div>'
                        + '<div class="col-33">'
                        + index.priority
                        + '</div>'
                        +'<div class="col-33"><a href="#" class="button delete" data-in="'
                        + index.productCategoryId
                        + '">删除</a></div>'
                        + '</div>';
                });
                $('.category-wrap').append(tempHtml);
            }
        });
    }
})