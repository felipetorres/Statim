package app.constant;

public enum Message {
	GPS {
		public String toJson(String json) {
			return "{"
					+ "\"message\" : \"gps\""
					+ "}";
		}
	},
	ITINERARY {
		@Override
		public String toJson(String json) {
			return "{"
					+ "\"message\" : \"itinerary\","
					+ "\"itinerary\" : " + json 
					+ "}";
		}
	};

	public abstract String toJson(String json);
}
