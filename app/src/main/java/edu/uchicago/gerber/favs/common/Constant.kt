package edu.uchicago.gerber.favs.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import edu.uchicago.gerber.favs.data.model.Business
import edu.uchicago.gerber.favs.data.model.BusinessResponse

object Constant {
    val authenticate = false

    val modifier = Modifier.padding(paddingValues = PaddingValues(all = 0.dp))

    val yelpUrl = "https://api.yelp.com/v3/"
    val fakeBusiness: Business = TODO()
    val fakeResponse: BusinessResponse = TODO()

    init {
        val gson = Gson()
        val hardCodedResponse =
    """
    {
    "businesses": [
        {
            "id": "8vFJH_paXsMocmEO_KAa3w",
            "alias": "lou-malnatis-pizzeria-chicago",
            "name": "Lou Malnati's Pizzeria",
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/HbfNtuWMgpp7TVeReWJ-Bg/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/lou-malnatis-pizzeria-chicago?adjust_creative=NvpBKpQOXp9JluV0mcbmdg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=NvpBKpQOXp9JluV0mcbmdg",
            "review_count": 7424,
            "categories": [
                {
                    "alias": "pizza",
                    "title": "Pizza"
                },
                {
                    "alias": "italian",
                    "title": "Italian"
                },
                {
                    "alias": "sandwiches",
                    "title": "Sandwiches"
                }
            ],
            "rating": 4.1,
            "coordinates": {
                "latitude": 41.890357,
                "longitude": -87.633704
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "439 North Wells St",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60610",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "439 North Wells St",
                    "Chicago, IL 60610"
                ]
            },
            "phone": "+13128289800",
            "display_phone": "(312) 828-9800",
            "distance": 4000.9990531720227,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://www.loumalnatis.com/our-menu",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "Bxd9Y2PsdvIOGIKFQh53RQ",
            "alias": "giordanos-chicago-30",
            "name": "Giordano's",
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/OKxuR9ZqBNY-4wvP0Z0SPQ/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/giordanos-chicago-30?adjust_creative=NvpBKpQOXp9JluV0mcbmdg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=NvpBKpQOXp9JluV0mcbmdg",
            "review_count": 3859,
            "categories": [
                {
                    "alias": "pizza",
                    "title": "Pizza"
                },
                {
                    "alias": "salad",
                    "title": "Salad"
                },
                {
                    "alias": "italian",
                    "title": "Italian"
                }
            ],
            "rating": 3.8,
            "coordinates": {
                "latitude": 41.88513231411071,
                "longitude": -87.62375615999174
            },
            "transactions": [
                "delivery"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "130 E Randolph St",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60601",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "130 E Randolph St",
                    "Chicago, IL 60601"
                ]
            },
            "phone": "+13126161200",
            "display_phone": "(312) 616-1200",
            "distance": 4994.255603493764,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://giordanos.com/the-menu/",
                "open24_hours": false,
                "waitlist_reservation": null
            }
        },
        {
            "id": "DXwSYgiXqIVNdO9dazel6w",
            "alias": "pequods-pizza-chicago-3",
            "name": "Pequod's Pizza",
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/8QJUNblfCI0EDhOjuIWJ4A/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/pequods-pizza-chicago-3?adjust_creative=NvpBKpQOXp9JluV0mcbmdg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=NvpBKpQOXp9JluV0mcbmdg",
            "review_count": 8249,
            "categories": [
                {
                    "alias": "pizza",
                    "title": "Pizza"
                }
            ],
            "rating": 3.9,
            "coordinates": {
                "latitude": 41.92187,
                "longitude": -87.664486
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "2207 N Clybourn Ave",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60614",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "2207 N Clybourn Ave",
                    "Chicago, IL 60614"
                ]
            },
            "phone": "+17733271512",
            "display_phone": "(773) 327-1512",
            "distance": 2158.7084581522413,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": true,
                            "start": "1100",
                            "end": "0200",
                            "day": 0
                        },
                        {
                            "is_overnight": true,
                            "start": "1100",
                            "end": "0200",
                            "day": 1
                        },
                        {
                            "is_overnight": true,
                            "start": "1100",
                            "end": "0200",
                            "day": 2
                        },
                        {
                            "is_overnight": true,
                            "start": "1100",
                            "end": "0200",
                            "day": 3
                        },
                        {
                            "is_overnight": true,
                            "start": "1100",
                            "end": "0200",
                            "day": 4
                        },
                        {
                            "is_overnight": true,
                            "start": "1100",
                            "end": "0200",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://pequodspizza.com/chicago/menu/",
                "open24_hours": false,
                "waitlist_reservation": null
            }
        },
        {
            "id": "z8G5AfXYbJD2jQpSEF633g",
            "alias": "michaels-original-pizzeria-and-tavern-chicago",
            "name": "Michael's Original Pizzeria & Tavern",
            "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/fzoCYSAj5S6YGcN4pjSwPg/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/michaels-original-pizzeria-and-tavern-chicago?adjust_creative=NvpBKpQOXp9JluV0mcbmdg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=NvpBKpQOXp9JluV0mcbmdg",
            "review_count": 851,
            "categories": [
                {
                    "alias": "pubs",
                    "title": "Pubs"
                },
                {
                    "alias": "tradamerican",
                    "title": "American"
                },
                {
                    "alias": "pizza",
                    "title": "Pizza"
                }
            ],
            "rating": 4.3,
            "coordinates": {
                "latitude": 41.95685145525139,
                "longitude": -87.65186897780413
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "4091 N Broadway St",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60613",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "4091 N Broadway St",
                    "Chicago, IL 60613"
                ]
            },
            "phone": "+17739294149",
            "display_phone": "(773) 929-4149",
            "distance": 6134.11840808247,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2300",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "0000",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://www.michaelspizzachicago.com/",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "YSAT4vjNq4SkrpOWQ-Q1QQ",
            "alias": "lusha-chicago",
            "name": "Lusha",
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/Av9H2W7JlsiM0jNrlROmtw/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/lusha-chicago?adjust_creative=NvpBKpQOXp9JluV0mcbmdg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=NvpBKpQOXp9JluV0mcbmdg",
            "review_count": 6,
            "categories": [
                {
                    "alias": "pizza",
                    "title": "Pizza"
                },
                {
                    "alias": "desserts",
                    "title": "Desserts"
                },
                {
                    "alias": "chicken_wings",
                    "title": "Chicken Wings"
                }
            ],
            "rating": 5.0,
            "coordinates": {
                "latitude": 41.93330394570271,
                "longitude": -87.6593947
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "location": {
                "address1": "2825 N Lincoln Ave",
                "address2": "",
                "address3": null,
                "city": "Chicago",
                "zip_code": "60657",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "2825 N Lincoln Ave",
                    "Chicago, IL 60657"
                ]
            },
            "phone": "+13125231687",
            "display_phone": "(312) 523-1687",
            "distance": 3479.110826044243,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2000",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": null,
                "open24_hours": null,
                "waitlist_reservation": null
            }
        }
    ],
    "total": 8700,
    "region": {
        "center": {
            "longitude": -87.67776489257812,
            "latitude": 41.90515925618311
        }
    }
}
    
    """
        Constant.fakeResponse =
            gson.fromJson<BusinessResponse>(hardCodedResponse, BusinessResponse::class.java)
        fakeBusiness = Constant.fakeResponse.businesses[0]
    }

}