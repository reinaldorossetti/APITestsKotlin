package requests

import core.Setup
import factory.Product
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response


open class ProductRequests : Setup() {

    open fun getAllProducts(): Response {
        val response =
            Given {
                spec(requestSpecification)
                    .filter(RequestLoggingFilter(LogDetail.ALL))
                    .filter(ResponseLoggingFilter(LogDetail.ALL))
            } When {
                get("/produtos")
            } Then {
            } Extract {
                response()
            }
        return response
    }

    open fun getProductById(_id: String): Response {
        val response =
            Given {
                spec(requestSpecification)
                    .filter(RequestLoggingFilter(LogDetail.ALL))
                    .filter(ResponseLoggingFilter(LogDetail.ALL))
            } When {
                get("/produtos/$_id")
            } Then {
            } Extract {
                response()
            }
        return response
    }

    open fun createNewProduct(product: Product, token: String): Response {
        val response =
            Given {
                spec(requestSpecification)
                    .filter(RequestLoggingFilter(LogDetail.ALL))
                    .filter(ResponseLoggingFilter(LogDetail.ALL))
                    .header("Authorization", token)
                    .body(gson.toJson(product))
            } When {
                post("/produtos")
            } Then {
            } Extract {
                response()
            }
        return response
    }

    open fun updateProduct(product: Product, _id: String, token: String): Response {
        val response =
            Given {
                spec(requestSpecification)
                    .filter(RequestLoggingFilter(LogDetail.ALL))
                    .filter(ResponseLoggingFilter(LogDetail.ALL))
                    .header("Authorization", token)
                    .body(gson.toJson(product))
            } When {
                put("/produtos/$_id")
            } Then {
            } Extract {
                response()
            }
        return response
    }

    open fun deleteProduct(_id: String, token: String): Response {
        val response =
            Given {
                spec(requestSpecification)
                    .filter(RequestLoggingFilter(LogDetail.ALL))
                    .filter(ResponseLoggingFilter(LogDetail.ALL))
                    .header("Authorization", token)
            } When {
                delete("/produtos/$_id")
            } Then {
            } Extract {
                response()
            }
        return response
    }
}
