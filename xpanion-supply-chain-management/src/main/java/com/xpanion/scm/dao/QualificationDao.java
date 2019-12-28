package com.xpanion.scm.dao;

import java.util.List;


import com.xpanion.scm.model.QualificationModel;

public interface QualificationDao {
	public List<QualificationModel> getQualificationType();
	public List<QualificationModel> getEmpQualiDet(int employeeId);
}
