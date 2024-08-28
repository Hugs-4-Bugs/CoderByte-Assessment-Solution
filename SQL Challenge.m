-- __define-ocg__
SELECT 
  m.GroupID, 
  vi.CompanyName, 
  COUNT(*) AS Count
FROM 
  maintable_NXBTX m 
  JOIN cb_vendorinformation vi ON m.GroupID = vi.GroupID
GROUP BY 
  m.GroupID, vi.CompanyName
ORDER BY 
  Count ASC, m.GroupID DESC, vi.CompanyName ASC;
