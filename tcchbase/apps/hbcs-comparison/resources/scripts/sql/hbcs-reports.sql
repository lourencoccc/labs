SELECT * FROM hbcs_results


SELECT label, database, queryId, datamodel, processor, AVG(DURATIONMILLIS) 
FROM hbcs_results 
GROUP BY (label, database, queryId, datamodel, processor)
ORDER BY label, database, queryId, datamodel, processor;


SELECT label, database, queryId, datamodel, SUM(DURATIONMILLIS) 
FROM (
		SELECT label, database, queryId, datamodel, processor, AVG(DURATIONMILLIS) as DURATIONMILLIS 
		FROM hbcs_results 
		GROUP BY (label, database, queryId, datamodel, processor)
	) 
GROUP BY (label, database, queryId, datamodel)
ORDER BY label, database, queryId, datamodel;