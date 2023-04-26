select c.apnt_no, a.pt_name, a.pt_no, b.mcdp_cd, b.dr_name, c.apnt_ymd
from patient a join appointment c on a.pt_no = c.pt_no join doctor b on b.dr_id = c.mddr_id
where c.apnt_ymd like "2022-04-13%" and c.apnt_cncl_ymd is null and c.mcdp_cd = "CS"
order by c.apnt_ymd