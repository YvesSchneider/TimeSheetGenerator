/* Licensed under MIT 2024. */
package ui.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

// TODO: Why a custom serializer?
@JsonSerialize(using = GlobalSerialzer.class)
public class Global {
	@JsonProperty("$schema")
	private String schema;
	private String name;
	private int staffId;
	private String department;
	private String workingTime;
	private double wage;
	private String workingArea;

	public Global() {
		schema = "https://raw.githubusercontent.com/kit-sdq/TimeSheetGenerator/main/examples/schemas/global.json";
	}

	// Constructors, Getters, and Setters

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public String getWorkingArea() {
		return workingArea;
	}

	public void setWorkingArea(String workingArea) {
		this.workingArea = workingArea;
	}

	// TODO Naming & Docs
	public String getFormattedName() {
		if (!getName().contains(" ")) {
			return getName();
		}
		StringBuilder name = new StringBuilder();
		String[] names = getName().split(" ");
		name.append(names[names.length - 1]).append(",");
		for (int i = 0; i < names.length - 1; ++i) {
			name.append(" ").append(names[i]);
		}
		return name.toString();
	}

	/**
	 * Like getFormattedName but without comma and underscored instead of spaces.
	 * 
	 * @return Formatted name but for file exporting.
	 */
	// TODO Naming
	public String getFormattedName2() {
		if (!getName().contains(" ")) {
			return getName();
		}
		StringBuilder name = new StringBuilder();
		String[] names = getName().split(" ");
		name.append(names[names.length - 1]);
		for (int i = 0; i < names.length - 1; ++i) {
			name.append("_").append(names[i]);
		}
		return name.toString();
	}
}
