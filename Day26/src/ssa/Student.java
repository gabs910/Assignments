package ssa;

public class Student {
		int id;
		String firstName;
		String lastName;
		double gpa;
		int sat;
		
		@Override
		public String toString() {
			String info = String.format("%3d %-25s %4.2f %4d",
					this.id, this.firstName+" "+this.lastName,
					this.gpa,this.sat);
					
			return info;
		}
		Student() {
			
		}
}
