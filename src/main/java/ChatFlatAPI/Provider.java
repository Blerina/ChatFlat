package ChatFlatAPI;

import java.util.List;

public interface Provider {
	Conversation createConversation();
	List<Conversation> getConversations();
	Message createMessage(String id);
}
