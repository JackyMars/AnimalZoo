package com.example.taipeizoo.network

data class ResultModel(val result:ResultInfo)
data class ResultInfo(val limit:Int,val offset:Int,val count:Int,val results:ArrayList<AnimalInfo>)
/***
 * a_name_ch 中文名
 * a_location 館區
 * a_distribution 地理分布
 * a_phylum 分類學_門
 * a_class  分類學_綱
 * a_order  分類學_目
 * a_family 分類學_科
 * a_feature 形態特徵
 * a_behavior 生態習性
 * a_diet 食性
 * a_pic01_url 照片說明及URL
 */
data class AnimalInfo(val a_name_ch:String,
                      val a_location:String,
                      val a_distribution:String,
                      val a_phylum:String,
                      val a_class:String,
                      val a_order:String,
                      val a_family:String,
                      val a_feature:String,
                      val a_behavior:String,
                      val a_diet:String,
                      val a_pic01_url:String)
