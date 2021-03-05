package ChatFlatAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("_id")
	private String id;
	private String createdAt;
	private String name;
	private String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	
	@Override
	public String toString() {
		return id + " " + createdAt + " " + name + " " + text;
	}

}
