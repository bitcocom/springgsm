package kr.covid.scraper;


public class CovidStatus {
	 private String region;
	    private int total;
	    private int domestic;
	    private int abroad;
	    private int confirmed;
	    private int deaths;
	    private double rate;
	    public CovidStatus() {  }
	    // 기존 코드: 생성자, toString 메서드 등
	    public CovidStatus(String region, int total, int domestic, int abroad, int confirmed, int deaths, double rate) {
			super();
			this.region = region;
			this.total = total;
			this.domestic = domestic;
			this.abroad = abroad;
			this.confirmed = confirmed;
			this.deaths = deaths;
			this.rate = rate;
		}
	    // Getter 메서드 추가
	    public String getRegion() {
	        return region;
	    }

	    

		public int getTotal() {
	        return total;
	    }

	    public int getDomestic() {
	        return domestic;
	    }

	    public int getAbroad() {
	        return abroad;
	    }

	    public int getConfirmed() {
	        return confirmed;
	    }

	    public int getDeaths() {
	        return deaths;
	    }

	    public double getRate() {
	        return rate;
	    }


	@Override
	public String toString() {
	    return String.format("%s | %d | %d | %d | %d | %d | %.2f", region, total, domestic, abroad, confirmed, deaths, rate);
	}

}

