package vergleicherUebung;

public class MyFussballer implements Comparable<MyFussballer>{
	Integer nummer;
	
	public MyFussballer(Integer nummer) {
		this.nummer = nummer;
	}

	@Override
	public int compareTo(MyFussballer o) {
		return this.nummer.compareTo(o.nummer);
	}

}
