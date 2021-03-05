package ChatFlatAPI;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Provider provider = ProviderType.CHATFLAT.getProvider();
		
		Conversation c = provider.createConversation();
		provider.createMessage(c.getId());
		provider.createMessage(c.getId());
		provider.createMessage(c.getId());

		List<Conversation> conversations = provider.getConversations();
		
		printConversationMessageCount(conversations);
	}
	
	public static void printConversationMessageCount(List<Conversation> conversations) {
		for(Conversation c : conversations) {
			System.out.println("Conversation with id: " + c.getId() + " has " + c.getMessages().size() + " messages");
		}
	}
	
}
