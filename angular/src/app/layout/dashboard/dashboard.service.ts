import {Injectable, Inject} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Headers, URLSearchParams, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import { ResourceCount } from '../../shared/resourceCount';

@Injectable()
export class DashboardService {

    constructor (private http: HttpClient) {}
    /*getAllChartData(): Observable<ChartData[]> {
        const uri = 'http://localhost:8080/resmgt/api/attrition/';
        return this
            .http
            .get(uri)
            .map(res => {
                return res as ChartData[];
            });
    }

    getLocationWiseCount()  {
        const uri = 'http://localhost:8080/resmgt/api/locationwiseuser/';
        return this
            .http
            .get(uri)
            .map(res => {
                return res;
            });
    }

    getProjectTypeBillCount() {
        const uri = 'http://localhost:8080/resmgt/api/projbillcount/';
        return this
            .http
            .get(uri)
            .map(res => {
                return res;
            });
    }*/

    getResourceCount(month: string, chartType: string): Observable<ResourceCount[]> {
        const uri = 'http://localhost:8080/resmgt/api/resourceCount/' + month + '/' + chartType;
        return this
            .http
            .get(uri)
            .map(res => {
                return res as ResourceCount[];
            });
    }
}
