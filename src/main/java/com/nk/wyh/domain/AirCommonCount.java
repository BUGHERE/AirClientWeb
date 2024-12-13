package com.nk.wyh.domain;

public class AirCommonCount {
    private String member_no = "";
    private String ffp_date = "";
    private String first_flight_date = "";
    private String gender = "";
    private String ffp_tier = "";
    private String work_city = "";
    private String work_province = "";
    private String work_country = "";
    private String age = "";
    private String load_time = "";
    private String flight_count = "";
    private String bp_sum = "";
    private String ep_sum_yr_1 = "";
    private String ep_sum_yr_2 = "";
    private String sum_yr_1 = "";
    private String sum_yr_2 = "";
    private String seg_km_sum = "";
    private String weighted_seg_km = "";
    private String last_flight_date = "";
    private String avg_flight_count = "";
    private String avg_bp_sum = "";
    private String begin_to_first = "";
    private String last_to_end = "";
    private String avg_interval = "";
    private String max_interval = "";
    private String add_points_sum_yr_1 = "";
    private String add_points_sum_yr_2 = "";
    private String exchange_count = "";
    private String avg_discount = "";
    private String p1y_flight_count = "";
    private String l1y_flight_count = "";
    private String p1y_bp_sum = "";
    private String l1y_bp_sum = "";
    private String ep_sum = "";
    private String add_point_sum = "";
    private String eli_add_point_sum = "";
    private String l1y_eli_add_points = "";
    private String points_sum = "";
    private String l1y_points_sum = "";
    private String ration_l1y_flight_count = "";
    private String ration_p1y_flight_count = "";
    private String ration_p1y_bps = "";
    private String ration_l1y_bps = "";
    private String point_notflight = "";
    private int number;

    @Override
    public String toString() {
        return "AirCommonCount{" +
                "member_no='" + member_no + '\'' +
                ", ffp_date='" + ffp_date + '\'' +
                ", first_flight_date='" + first_flight_date + '\'' +
                ", gender='" + gender + '\'' +
                ", ffp_tier='" + ffp_tier + '\'' +
                ", work_city='" + work_city + '\'' +
                ", work_province='" + work_province + '\'' +
                ", work_country='" + work_country + '\'' +
                ", age='" + age + '\'' +
                ", load_time='" + load_time + '\'' +
                ", flight_count='" + flight_count + '\'' +
                ", bp_sum='" + bp_sum + '\'' +
                ", ep_sum_yr_1='" + ep_sum_yr_1 + '\'' +
                ", ep_sum_yr_2='" + ep_sum_yr_2 + '\'' +
                ", sum_yr_1='" + sum_yr_1 + '\'' +
                ", sum_yr_2='" + sum_yr_2 + '\'' +
                ", seg_km_sum='" + seg_km_sum + '\'' +
                ", weighted_seg_km='" + weighted_seg_km + '\'' +
                ", last_flight_date='" + last_flight_date + '\'' +
                ", avg_flight_count='" + avg_flight_count + '\'' +
                ", avg_bp_sum='" + avg_bp_sum + '\'' +
                ", begin_to_first='" + begin_to_first + '\'' +
                ", last_to_end='" + last_to_end + '\'' +
                ", avg_interval='" + avg_interval + '\'' +
                ", max_interval='" + max_interval + '\'' +
                ", add_points_sum_yr_1='" + add_points_sum_yr_1 + '\'' +
                ", add_points_sum_yr_2='" + add_points_sum_yr_2 + '\'' +
                ", exchange_count='" + exchange_count + '\'' +
                ", avg_discount='" + avg_discount + '\'' +
                ", p1y_flight_count='" + p1y_flight_count + '\'' +
                ", l1y_flight_count='" + l1y_flight_count + '\'' +
                ", p1y_bp_sum='" + p1y_bp_sum + '\'' +
                ", l1y_bp_sum='" + l1y_bp_sum + '\'' +
                ", ep_sum='" + ep_sum + '\'' +
                ", add_point_sum='" + add_point_sum + '\'' +
                ", eli_add_point_sum='" + eli_add_point_sum + '\'' +
                ", l1y_eli_add_points='" + l1y_eli_add_points + '\'' +
                ", points_sum='" + points_sum + '\'' +
                ", l1y_points_sum='" + l1y_points_sum + '\'' +
                ", ration_l1y_flight_count='" + ration_l1y_flight_count + '\'' +
                ", ration_p1y_flight_count='" + ration_p1y_flight_count + '\'' +
                ", ration_p1y_bps='" + ration_p1y_bps + '\'' +
                ", ration_l1y_bps='" + ration_l1y_bps + '\'' +
                ", point_notflight='" + point_notflight + '\'' +
                ", number=" + number +
                '}';
    }

    public String getMember_no() {
        return member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    public String getFfp_date() {
        return ffp_date;
    }

    public void setFfp_date(String ffp_date) {
        this.ffp_date = ffp_date;
    }

    public String getFirst_flight_date() {
        return first_flight_date;
    }

    public void setFirst_flight_date(String first_flight_date) {
        this.first_flight_date = first_flight_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFfp_tier() {
        return ffp_tier;
    }

    public void setFfp_tier(String ffp_tier) {
        this.ffp_tier = ffp_tier;
    }

    public String getWork_city() {
        return work_city;
    }

    public void setWork_city(String work_city) {
        this.work_city = work_city;
    }

    public String getWork_province() {
        return work_province;
    }

    public void setWork_province(String work_province) {
        this.work_province = work_province;
    }

    public String getWork_country() {
        return work_country;
    }

    public void setWork_country(String work_country) {
        this.work_country = work_country;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLoad_time() {
        return load_time;
    }

    public void setLoad_time(String load_time) {
        this.load_time = load_time;
    }

    public String getFlight_count() {
        return flight_count;
    }

    public void setFlight_count(String flight_count) {
        this.flight_count = flight_count;
    }

    public String getBp_sum() {
        return bp_sum;
    }

    public void setBp_sum(String bp_sum) {
        this.bp_sum = bp_sum;
    }

    public String getEp_sum_yr_1() {
        return ep_sum_yr_1;
    }

    public void setEp_sum_yr_1(String ep_sum_yr_1) {
        this.ep_sum_yr_1 = ep_sum_yr_1;
    }

    public String getEp_sum_yr_2() {
        return ep_sum_yr_2;
    }

    public void setEp_sum_yr_2(String ep_sum_yr_2) {
        this.ep_sum_yr_2 = ep_sum_yr_2;
    }

    public String getSum_yr_1() {
        return sum_yr_1;
    }

    public void setSum_yr_1(String sum_yr_1) {
        this.sum_yr_1 = sum_yr_1;
    }

    public String getSum_yr_2() {
        return sum_yr_2;
    }

    public void setSum_yr_2(String sum_yr_2) {
        this.sum_yr_2 = sum_yr_2;
    }

    public String getSeg_km_sum() {
        return seg_km_sum;
    }

    public void setSeg_km_sum(String seg_km_sum) {
        this.seg_km_sum = seg_km_sum;
    }

    public String getWeighted_seg_km() {
        return weighted_seg_km;
    }

    public void setWeighted_seg_km(String weighted_seg_km) {
        this.weighted_seg_km = weighted_seg_km;
    }

    public String getLast_flight_date() {
        return last_flight_date;
    }

    public void setLast_flight_date(String last_flight_date) {
        this.last_flight_date = last_flight_date;
    }

    public String getAvg_flight_count() {
        return avg_flight_count;
    }

    public void setAvg_flight_count(String avg_flight_count) {
        this.avg_flight_count = avg_flight_count;
    }

    public String getAvg_bp_sum() {
        return avg_bp_sum;
    }

    public void setAvg_bp_sum(String avg_bp_sum) {
        this.avg_bp_sum = avg_bp_sum;
    }

    public String getBegin_to_first() {
        return begin_to_first;
    }

    public void setBegin_to_first(String begin_to_first) {
        this.begin_to_first = begin_to_first;
    }

    public String getLast_to_end() {
        return last_to_end;
    }

    public void setLast_to_end(String last_to_end) {
        this.last_to_end = last_to_end;
    }

    public String getAvg_interval() {
        return avg_interval;
    }

    public void setAvg_interval(String avg_interval) {
        this.avg_interval = avg_interval;
    }

    public String getMax_interval() {
        return max_interval;
    }

    public void setMax_interval(String max_interval) {
        this.max_interval = max_interval;
    }

    public String getAdd_points_sum_yr_1() {
        return add_points_sum_yr_1;
    }

    public void setAdd_points_sum_yr_1(String add_points_sum_yr_1) {
        this.add_points_sum_yr_1 = add_points_sum_yr_1;
    }

    public String getAdd_points_sum_yr_2() {
        return add_points_sum_yr_2;
    }

    public void setAdd_points_sum_yr_2(String add_points_sum_yr_2) {
        this.add_points_sum_yr_2 = add_points_sum_yr_2;
    }

    public String getExchange_count() {
        return exchange_count;
    }

    public void setExchange_count(String exchange_count) {
        this.exchange_count = exchange_count;
    }

    public String getAvg_discount() {
        return avg_discount;
    }

    public void setAvg_discount(String avg_discount) {
        this.avg_discount = avg_discount;
    }

    public String getP1y_flight_count() {
        return p1y_flight_count;
    }

    public void setP1y_flight_count(String p1y_flight_count) {
        this.p1y_flight_count = p1y_flight_count;
    }

    public String getL1y_flight_count() {
        return l1y_flight_count;
    }

    public void setL1y_flight_count(String l1y_flight_count) {
        this.l1y_flight_count = l1y_flight_count;
    }

    public String getP1y_bp_sum() {
        return p1y_bp_sum;
    }

    public void setP1y_bp_sum(String p1y_bp_sum) {
        this.p1y_bp_sum = p1y_bp_sum;
    }

    public String getL1y_bp_sum() {
        return l1y_bp_sum;
    }

    public void setL1y_bp_sum(String l1y_bp_sum) {
        this.l1y_bp_sum = l1y_bp_sum;
    }

    public String getEp_sum() {
        return ep_sum;
    }

    public void setEp_sum(String ep_sum) {
        this.ep_sum = ep_sum;
    }

    public String getAdd_point_sum() {
        return add_point_sum;
    }

    public void setAdd_point_sum(String add_point_sum) {
        this.add_point_sum = add_point_sum;
    }

    public String getEli_add_point_sum() {
        return eli_add_point_sum;
    }

    public void setEli_add_point_sum(String eli_add_point_sum) {
        this.eli_add_point_sum = eli_add_point_sum;
    }

    public String getL1y_eli_add_points() {
        return l1y_eli_add_points;
    }

    public void setL1y_eli_add_points(String l1y_eli_add_points) {
        this.l1y_eli_add_points = l1y_eli_add_points;
    }

    public String getPoints_sum() {
        return points_sum;
    }

    public void setPoints_sum(String points_sum) {
        this.points_sum = points_sum;
    }

    public String getL1y_points_sum() {
        return l1y_points_sum;
    }

    public void setL1y_points_sum(String l1y_points_sum) {
        this.l1y_points_sum = l1y_points_sum;
    }

    public String getRation_l1y_flight_count() {
        return ration_l1y_flight_count;
    }

    public void setRation_l1y_flight_count(String ration_l1y_flight_count) {
        this.ration_l1y_flight_count = ration_l1y_flight_count;
    }

    public String getRation_p1y_flight_count() {
        return ration_p1y_flight_count;
    }

    public void setRation_p1y_flight_count(String ration_p1y_flight_count) {
        this.ration_p1y_flight_count = ration_p1y_flight_count;
    }

    public String getRation_p1y_bps() {
        return ration_p1y_bps;
    }

    public void setRation_p1y_bps(String ration_p1y_bps) {
        this.ration_p1y_bps = ration_p1y_bps;
    }

    public String getRation_l1y_bps() {
        return ration_l1y_bps;
    }

    public void setRation_l1y_bps(String ration_l1y_bps) {
        this.ration_l1y_bps = ration_l1y_bps;
    }

    public String getPoint_notflight() {
        return point_notflight;
    }

    public void setPoint_notflight(String point_notflight) {
        this.point_notflight = point_notflight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public AirCommonCount() {
    }

    public AirCommonCount(String member_no, String ffp_date, String first_flight_date, String gender, String ffp_tier, String work_city, String work_province, String work_country, String age, String load_time, String flight_count, String bp_sum, String ep_sum_yr_1, String ep_sum_yr_2, String sum_yr_1, String sum_yr_2, String seg_km_sum, String weighted_seg_km, String last_flight_date, String avg_flight_count, String avg_bp_sum, String begin_to_first, String last_to_end, String avg_interval, String max_interval, String add_points_sum_yr_1, String add_points_sum_yr_2, String exchange_count, String avg_discount, String p1y_flight_count, String l1y_flight_count, String p1y_bp_sum, String l1y_bp_sum, String ep_sum, String add_point_sum, String eli_add_point_sum, String l1y_eli_add_points, String points_sum, String l1y_points_sum, String ration_l1y_flight_count, String ration_p1y_flight_count, String ration_p1y_bps, String ration_l1y_bps, String point_notflight, int number) {
        this.member_no = member_no;
        this.ffp_date = ffp_date;
        this.first_flight_date = first_flight_date;
        this.gender = gender;
        this.ffp_tier = ffp_tier;
        this.work_city = work_city;
        this.work_province = work_province;
        this.work_country = work_country;
        this.age = age;
        this.load_time = load_time;
        this.flight_count = flight_count;
        this.bp_sum = bp_sum;
        this.ep_sum_yr_1 = ep_sum_yr_1;
        this.ep_sum_yr_2 = ep_sum_yr_2;
        this.sum_yr_1 = sum_yr_1;
        this.sum_yr_2 = sum_yr_2;
        this.seg_km_sum = seg_km_sum;
        this.weighted_seg_km = weighted_seg_km;
        this.last_flight_date = last_flight_date;
        this.avg_flight_count = avg_flight_count;
        this.avg_bp_sum = avg_bp_sum;
        this.begin_to_first = begin_to_first;
        this.last_to_end = last_to_end;
        this.avg_interval = avg_interval;
        this.max_interval = max_interval;
        this.add_points_sum_yr_1 = add_points_sum_yr_1;
        this.add_points_sum_yr_2 = add_points_sum_yr_2;
        this.exchange_count = exchange_count;
        this.avg_discount = avg_discount;
        this.p1y_flight_count = p1y_flight_count;
        this.l1y_flight_count = l1y_flight_count;
        this.p1y_bp_sum = p1y_bp_sum;
        this.l1y_bp_sum = l1y_bp_sum;
        this.ep_sum = ep_sum;
        this.add_point_sum = add_point_sum;
        this.eli_add_point_sum = eli_add_point_sum;
        this.l1y_eli_add_points = l1y_eli_add_points;
        this.points_sum = points_sum;
        this.l1y_points_sum = l1y_points_sum;
        this.ration_l1y_flight_count = ration_l1y_flight_count;
        this.ration_p1y_flight_count = ration_p1y_flight_count;
        this.ration_p1y_bps = ration_p1y_bps;
        this.ration_l1y_bps = ration_l1y_bps;
        this.point_notflight = point_notflight;
        this.number = number;
    }
}
