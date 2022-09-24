package com.dldmswo1209.dawnproject.model

import com.dldmswo1209.dawnproject.R

val categoryList = mutableListOf<CategoryItem>(
    CategoryItem(R.drawable.image_box, "전체"),
    CategoryItem(R.drawable.image_box, "상의"),
    CategoryItem(R.drawable.image_box, "하의"),
    CategoryItem(R.drawable.image_box, "아우터"),
    CategoryItem(R.drawable.image_box, "신발"),
    CategoryItem(R.drawable.image_box, "스커트"),
    CategoryItem(R.drawable.image_box, "원피스"),
    CategoryItem(R.drawable.image_box, "가방"),
)
val codyRankList = mutableListOf(
    CodyRankItem(R.drawable.brand_test_image1, "드로우핏","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),
    CodyRankItem(R.drawable.brand_test_image2, "꼼파늘","#홈웨어 #캐주얼 #일상룩 #페미닌 #유니크",false),
    CodyRankItem(R.drawable.brand_test_image3, "라퍼지스토어","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),
    CodyRankItem(R.drawable.brand_test_image1, "나이키","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),
    CodyRankItem(R.drawable.brand_test_image2, "앤더슨벨","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),
    CodyRankItem(R.drawable.brand_test_image3, "Cos","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),
    CodyRankItem(R.drawable.brand_test_image2, "수아레","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),
    CodyRankItem(R.drawable.brand_test_image1, "파르티멘토","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩",false),

    )
var productRankList = mutableListOf(
    ProductItem(R.drawable.test_image,"아디다스","자체제작 / 크롭 후드 트레이닝","23%","76,500","상의",false),
    ProductItem(R.drawable.test_image2,"유니클로","제임스 반팔 카라 셔츠","40%","32,900","상의",false),
    ProductItem(R.drawable.test_image,"드로우핏","린넨 미니멀 베이지 셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.test_image2,"커버낫","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false),
    ProductItem(R.drawable.test_image2,"비바스튜디오","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false),
    ProductItem(R.drawable.test_image2,"아르마니","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false),
)
val recommendList = mutableListOf(
    ProductItem(R.drawable.recommend_test_image1,"캘빈클라인","[1+3] 이너 나시 4color","23%","76,500","상의",false),
    ProductItem(R.drawable.recommend_test_image2,"도프제이슨","크롭 레더 자켓","40%","32,900","상의",false),
    ProductItem(R.drawable.recommend_test_image3,"마르디 메크르디","블랙 피스 프린팅 반팔 티셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.recommend_test_image4,"타입서비스","자체제작 / 화이트 오프숄더 크...","","47,000","상의",false),
)
val bannerImages = mutableListOf(
    R.drawable.test_ad1,
    R.drawable.test_ad2,
    R.drawable.test_ad3
)
val bannerImages2 = mutableListOf(
    BannerItem(R.drawable.test_ad1),
    BannerItem(R.drawable.test_ad2),
    BannerItem(R.drawable.test_ad3)

)

val saleItems1 = mutableListOf(
    ProductItem(R.drawable.test_image,"아디다스","자체제작 / 크롭 후드 트레이닝","23%","76,500","상의",false),
    ProductItem(R.drawable.test_image2,"유니클로","제임스 반팔 카라 셔츠","40%","32,900","상의",false),
    ProductItem(R.drawable.test_image,"드로우핏","린넨 미니멀 베이지 셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.test_image2,"꼼파늘","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false),
)
val saleItems2 = mutableListOf(
    ProductItem(R.drawable.test_image,"테스트입니다.","자체제작 / 크롭 후드 트레이닝","23%","76,500","상의",false),
    ProductItem(R.drawable.test_image2,"테스트2","테스트 상세설명 입니다","40%","32,900","상의",false),
    ProductItem(R.drawable.test_image,"테스트3","린넨 미니멀 베이지 셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.test_image2,"테스트4","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false)
)
val saleItems3 = mutableListOf(
    ProductItem(R.drawable.test_image,"테스트입니다.","자체제작 / 크롭 후드 트레이닝","23%","76,500","상의",false),
    ProductItem(R.drawable.test_image2,"테스트2","테스트 상세설명 입니다","40%","32,900","상의",false),
    ProductItem(R.drawable.test_image,"테스트3","린넨 미니멀 베이지 셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.test_image2,"테스트4","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false)
)
val saleItems4 = mutableListOf(
    ProductItem(R.drawable.test_image,"테스트입니다.","자체제작 / 크롭 후드 트레이닝","23%","76,500","상의",false),
    ProductItem(R.drawable.test_image2,"테스트2","테스트 상세설명 입니다","40%","32,900","상의",false),
    ProductItem(R.drawable.test_image,"테스트3","린넨 미니멀 베이지 셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.test_image2,"테스트4","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false)
)
val saleItems5 = mutableListOf(
    ProductItem(R.drawable.test_image,"테스트입니다.","자체제작 / 크롭 후드 트레이닝","23%","76,500","상의",false),
    ProductItem(R.drawable.test_image2,"테스트2","테스트 상세설명 입니다","40%","32,900","상의",false),
    ProductItem(R.drawable.test_image,"테스트3","린넨 미니멀 베이지 셔츠","47%","69,900","상의",false),
    ProductItem(R.drawable.test_image2,"테스트4","자체제작 / 그레이 페미닌 퓨어...","","47,000","상의",false)
)
val brandList = mutableListOf(
    CategoryItem(R.drawable.brand_test_image,"칼하트"),
    CategoryItem(R.drawable.brand_test_image, "디스커버리"),
    CategoryItem(R.drawable.brand_test_image,"나이키"),
    CategoryItem(R.drawable.brand_test_image, "캉골"),
    CategoryItem(R.drawable.brand_test_image,"꼼파뇨"),
    CategoryItem(R.drawable.brand_test_image, "비바스튜디오"),
    CategoryItem(R.drawable.brand_test_image,"스컬피그"),
    CategoryItem(R.drawable.brand_test_image, "앤드모어"),
    CategoryItem(R.drawable.brand_test_image,"어반라인"),
    CategoryItem(R.drawable.brand_test_image, "베이델리"),
)
val shopList = mutableListOf(
    CategoryItem(R.drawable.brand_test_image,"베이델리"),
    CategoryItem(R.drawable.brand_test_image, "어반라인"),
    CategoryItem(R.drawable.brand_test_image,"스컬피그"),
    CategoryItem(R.drawable.brand_test_image, "앤드모어"),
    CategoryItem(R.drawable.brand_test_image,"꼼파뇨"),
    CategoryItem(R.drawable.brand_test_image, "비바스튜디오"),
    CategoryItem(R.drawable.brand_test_image,"스컬피그"),
    CategoryItem(R.drawable.brand_test_image, "앤드모어"),
    CategoryItem(R.drawable.brand_test_image,"어반라인"),
    CategoryItem(R.drawable.brand_test_image, "베이델리"),
)