package Class;

public class SqlResult {
		private String index;
		private String status;
		public SqlResult(String index, String status) {
			super();
			this.index = index;
			this.status = status;
		}
		public SqlResult() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getIndex() {
			return index;
		}
		public void setIndex(String index) {
			this.index = index;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
}
