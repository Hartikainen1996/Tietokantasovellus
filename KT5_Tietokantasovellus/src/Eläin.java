
public class El‰in {
	private String el‰inID;
	private String el‰inNimi;
	private String el‰inRotu;
	private String el‰inIk‰;
	

	public El‰in() {
		this.el‰inID = "null";
		this.el‰inNimi = "ei m‰‰ritelty";
		this.el‰inRotu = "ei m‰‰ritelty";
		this.el‰inIk‰ = "tuntematon";
		
	}

	public El‰in(String el‰inID, String el‰inNimi, String el‰inRotu, String el‰inIk‰) {
		super();
		this.el‰inID = el‰inID;
		this.el‰inNimi = el‰inNimi;
		this.el‰inRotu = el‰inRotu;
		this.el‰inIk‰ = el‰inIk‰;
	}

	public String getEl‰inNimi() {
		return el‰inNimi;
	}

	public void setEl‰inNimi(String el‰inNimi) {
		this.el‰inNimi = el‰inNimi;
	}

	public String getEl‰inRotu() {
		return el‰inRotu;
	}

	public void setEl‰inRotu(String el‰inRotu) {
		this.el‰inRotu = el‰inRotu;
	}

	public String getEl‰inIk‰() {
		return el‰inIk‰;
	}

	public void setEl‰inIk‰(String uusiEl‰inIk‰) {
		this.el‰inIk‰ = uusiEl‰inIk‰;
	}

	public String getEl‰inID() {
		return el‰inID;
	}

	public void setEl‰inID(String el‰inID) {
		this.el‰inID = el‰inID;
	}

	@Override
	public String toString() {
		
		String tiedot = "El‰in [el‰inID=" + el‰inID + ", el‰inNimi=" + el‰inNimi + ", el‰inRotu=" + el‰inRotu + ", el‰inIk‰="
				+ el‰inIk‰ + "]";
		return tiedot;
	}

	
}