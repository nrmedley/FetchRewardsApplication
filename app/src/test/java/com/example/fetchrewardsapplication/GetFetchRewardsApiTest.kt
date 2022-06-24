package com.example.fetchrewardsapplication
//
//import org.junit.runner.RunWith
//import org.junit.runners.JUnit4
//
//@RunWith(JUnit4::class)
////class GetFetchRewardsApiTest {
///*
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private val server = MockWebServer()
//    private lateinit var repository: FetchRewardsRepository
//    private lateinit var mockedResponse: String
//
//    private val gson = GsonBuilder()
//        .setLenient()
//        .create()
//
//    @Before
//    fun init() {
//
//        server.start(8000)
//
//        var BASE_URL = server.url("/").toString()
//
//        val okHttpClient = OkHttpClient
//            .Builder()
//            .build()
//        val service = Retrofit.Builder()
//            .addConverterFactory(MoshiConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build().create(FetchRewardsApi::class.java)
//
//        repository = FetchRewardsRepository()
//    }
//
//    @Test
//    fun testApiSuccess() {
//        mockedResponse = MockResponseFileReader("fetchRewards.json").content
//
//        server.enqueue(
//            MockResponse()
//                .setResponseCode(200)
//                .setBody(mockedResponse)
//        )
//
//        val response = runBlocking { repository.getFetchRewardsData()  }
//        val json = gson.toJson(response.body())
//
//        val resultResponse = JsonParser.parseString(json)
//        val expectedresponse = JsonParser.parseString(mockedResponse)
//
//        Assert.assertNotNull(response)
//        Assert.assertTrue(resultResponse.equals(expectedresponse))
//    }
//*/
//    /*@Test
//    fun testApi404() {
//        mockedResponse = MockResponseFileReader("fetchRewards.json").content
//
//        server.enqueue(
//            MockResponse()
//                .setResponseCode(404)
//                .setBody(mockedResponse)
//        )
//
//        val response = runBlocking { repository.getFetchRewardsData()  }
//        Assert.assertNotNull(response)
//        Assert.assertTrue(response.message().equals("Client Error"))
//        Assert.assertTrue(response.code()==404)
//    }
//*/
///*    @After
//    fun tearDown() {
//        server.shutdown()
//    }*/
////}