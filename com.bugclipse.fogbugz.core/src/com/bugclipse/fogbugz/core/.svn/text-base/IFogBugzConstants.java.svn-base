package com.bugclipse.fogbugz.core;

public class IFogBugzConstants {
	
	public enum ReportType{
		TIMESHEET("Timesheet","timesheet.rptdesign"),
		CASE_REPORT("Case Report","caselist.rptdesign");
		
		private ReportType(String name, String fileName) {
			this.typeName = name;
			this.reportFileName = fileName;
		}
		
		private String typeName;
		private String reportFileName;
		public String getReportFileName() {
			return reportFileName;
		}
		public String getTypeName() {
			return typeName;
		}
		
	}
	
	public enum ReportFormat{
				HTML("As HTML","html","html"),
				PDF("As PDF", "pdf", "pdf"),
				EXCEL("As XLS","xls","xls"),
				POSTSCRIPT("As POSTSCRIPT","postscript","ps");
				
		private String label;
		private String birtConstant;
		private String fileExtension;
		
		public String getBirtConstant() {
			return birtConstant;
		}

		public String getFileExtension() {
			return fileExtension;
		}

		public String getLabel() {
			return label;
		}

		private ReportFormat(String label, String birtConstant, String fileExtension) {
			this.label = label;
			this.birtConstant = birtConstant;
			this.fileExtension = fileExtension;
		}
	}

}
