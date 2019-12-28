package com.xpanion.scm.dao;

import java.util.List;


import com.xpanion.scm.model.ReportModel;

public interface ReportDao {
 public List<ReportModel> getitems();
 public List<ReportModel> getitemtype( int itemId);


}
