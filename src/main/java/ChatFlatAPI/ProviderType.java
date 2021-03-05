package ChatFlatAPI;


public enum ProviderType {
	CHATFLAT(new ChatFlatProvider()), FACEBOOK(new FacebookProvider());
	
	private Provider provider;

	ProviderType(Provider type) {
		this.provider = type;
	}
	
	public Provider getProvider() {
		return provider;
	}
}
