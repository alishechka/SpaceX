/* 
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

import com.google.gson.annotations.SerializedName

data class SpaceBaseListModel (

	@SerializedName("id") val id : Int,
	@SerializedName("active") val active : Boolean,
	@SerializedName("stages") val stages : Int,
	@SerializedName("boosters") val boosters : Int,
	@SerializedName("cost_per_launch") val cost_per_launch : Int,
	@SerializedName("success_rate_pct") val success_rate_pct : Int,
	@SerializedName("first_flight") val first_flight : String,
	@SerializedName("country") val country : String,
	@SerializedName("company") val company : String,
	@SerializedName("height") val height : Height,
	@SerializedName("diameter") val diameter : Diameter,
	@SerializedName("mass") val mass : Mass,
	@SerializedName("payload_weights") val payload_weights : List<Payload_weights>,
	@SerializedName("first_stage") val first_stage : First_stage,
	@SerializedName("second_stage") val second_stage : Second_stage,
	@SerializedName("engines") val engines : Engines,
	@SerializedName("landing_legs") val landing_legs : Landing_legs,
	@SerializedName("flickr_images") val flickr_images : List<String>,
	@SerializedName("wikipedia") val wikipedia : String,
	@SerializedName("description") val description : String,
	@SerializedName("rocket_id") val rocket_id : String,
	@SerializedName("rocket_name") val rocket_name : String,
	@SerializedName("rocket_type") val rocket_type : String
)