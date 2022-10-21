package com.rgv04.hr.domain.location;

import java.util.List;

public interface LocationRepositoryQueries {

	List<Location> ListByFilter(LocationFilter filter);

}
