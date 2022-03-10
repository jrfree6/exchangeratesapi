package exchangeratesapi.dto;

public class Currency{
    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private Rates rates;
    
	public final boolean isSuccess() {
		return success;
	}
	public final void setSuccess(boolean success) {
		this.success = success;
	}
	public final int getTimestamp() {
		return timestamp;
	}
	public final void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public final String getBase() {
		return base;
	}
	public final void setBase(String base) {
		this.base = base;
	}
	public final String getDate() {
		return date;
	}
	public final void setDate(String date) {
		this.date = date;
	}
	public final Rates getRates() {
		return rates;
	}
	public final void setRates(Rates rates) {
		this.rates = rates;
	}
}

