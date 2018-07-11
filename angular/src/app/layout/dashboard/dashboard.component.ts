import { Component, OnInit, Input } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { DashboardService } from './dashboard.service';
import { ResourceCount } from '../../shared/resourceCount';
import { Month } from './month';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {

    doughnutData: any;
    pieData: any;
    closeResult: string;
    resourceCount: ResourceCount[];
    attrChart = 'ATTR';
    locationWiseChart = 'LOC_CNT';
    projectTypeBillableChart = 'PRJ_BIL_CNT';

    public barChartLabels: string[] = [];
    public barChartData: any[] = [];
    public barChartType: string = 'bar';
    public barChartLegend: boolean = true;

    public doughnutChartLabels: string[] = [];
    public doughnutChartData: number[] = [];
    public doughnutChartType: string = 'doughnut';

    public pieChartLabels: string[] = [];
    public pieChartData: number[] = [];
    public pieChartType: string = 'pie';

    public alerts: Array<any> = [];
    public sliders: Array<any> = [];

    public barChartOptions: any = {
        scaleShowVerticalLines: false,
        responsive: true
    };

    monthsList = new Array<Month>();
    months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    public now: Date = new Date();
    year = this.now.getFullYear();
    month = this.months[this.now.getMonth()];
        
    public onMonthChange(monthName) {
        this.month = monthName;
        this.clearChartLabel();
        this.getAllChartData(this.month, this.attrChart, false);
        this.getResourceCount(this.month, this.locationWiseChart);
        this.getProjectTypeBillCount(this.month, this.projectTypeBillableChart);
    }

    open(content) {
        this.modalService.open(content).result.then((result) => {
            this.closeResult = `Closed with: ${result}`;
        }, (reason) => {
            this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        });
    }

    private getDismissReason(reason: any): string {
        if (reason === ModalDismissReasons.ESC) {
            return 'by pressing ESC';
        } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
            return 'by clicking on a backdrop';
        } else {
            return `with: ${reason}`;
        }
    }

    //Buffer ratio chart hardcoded - need to change
    public barChartOptions1: any = {
        scaleShowVerticalLines: false,
        responsive: true
    };
    public barChartLabels1: string[] = ['2008', '2009', '2010', '2011', '2012'];
    public barChartType1: string = 'bar';
    public barChartLegend1: boolean = true;

    public barChartData1: any[] = [
        { data: [5.4, 6, 5.9, 5.23, 4.91], label: 'Without buffer' },
        { data: [6.2, 7.1, 6.9, 6.26, 5.93], label: 'With buffer' }
    ];

   constructor(private modalService: NgbModal, private service: DashboardService) {

        this.sliders.push(
            {
                imagePath: 'assets/images/bbh1.jpg',
                label: 'Daylight savings',
                text:
                    'Daylight savings changes from 11th March'
            },
            {
                imagePath: 'assets/images/bbh2.jpg',
                label: 'Mona chopra Visit',
                text: 'Mona Chopra visit Hexaware Mumbai office on 19th March.'
            },
            {
                imagePath: 'assets/images/bbh3.jpg',
                label: 'KPI Matrix ',
                text:
                    'KPI Matrix for March to be prepared.'
            }
        );

        this.alerts.push(
            {
                id: 1,
                type: 'success',
                message: `Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Voluptates est animi quibusdam praesentium quam, et perspiciatis,
                consectetur velit culpa molestias dignissimos
                voluptatum veritatis quod aliquam! Rerum placeat necessitatibus, vitae dolorum`
            },
            {
                id: 2,
                type: 'warning',
                message: `Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Voluptates est animi quibusdam praesentium quam, et perspiciatis,
                consectetur velit culpa molestias dignissimos
                voluptatum veritatis quod aliquam! Rerum placeat necessitatibus, vitae dolorum`
            }
        );
   }

   ngOnInit() {
        this.month = this.month + '-' + this.year;
        this.getAllChartData(this.month, this.attrChart, true);
        this.getResourceCount(this.month, this.locationWiseChart);
        this.getProjectTypeBillCount(this.month, this.projectTypeBillableChart);
   }

   clearChartLabel() {
       this.barChartLabels= [];
   }
   
   getAllChartData(month: string, chartType: string, populateDropdown: boolean) {
        this.service.getResourceCount(month, chartType).subscribe(res => {
            this.resourceCount = res;
            let tempChartDataType = '';
            var monthTemp : Month = null;
            var keepGoing = true;
            var count: number = 0;
            const tempChartData = [];
            const tempChartDataTypeLabel = [];
            this.resourceCount.forEach((item, index) => {
                if(keepGoing) {
                    tempChartDataTypeLabel.push(item.dataType);
                    tempChartData.push(item.monthCount);
                    tempChartDataType = this.attrChart;
                    if(count == 5) {                                //show first 6 records only
                        keepGoing = false;
                    }
                    count = count + 1;
                }
                if(populateDropdown) {
                    monthTemp = new Month(item.id, item.monthName);
                    this.monthsList.push(monthTemp);
                }
            });
            tempChartDataType = tempChartDataType + ' %';
            this.barChartLabels = tempChartDataTypeLabel;
            this.barChartData = [{data: tempChartData, label: tempChartDataType}];
         }
         err => this.logError(err)
         );
   }

   logError(err: any) {
        console.log(err);
    }


   public getResourceCount(month: string, chartType: string) {
        this.service.getResourceCount(month, chartType).subscribe(res => {
            this.resourceCount = res;
            const tempChartData = [];
            const tempChartLabel = [];
            this.resourceCount.forEach((item, index) => {
                    tempChartLabel.push(item.dataType);
                    tempChartData.push(item.monthCount);
            });
            this.doughnutChartLabels = tempChartLabel;
            this.doughnutChartData = tempChartData;
         });
   }

    public getProjectTypeBillCount(month: string, chartType: string) {
        this.service.getResourceCount(month, chartType).subscribe(res => {
            this.resourceCount = res;
            const tempChartData = [];
            const tempChartLabel = [];
            this.resourceCount.forEach((item, index) => {
                    tempChartLabel.push(item.dataType);
                    tempChartData.push(item.monthCount);
            });
            this.pieChartLabels = tempChartLabel;
            this.pieChartData = tempChartData;
         });
   }

    public closeAlert(alert: any) {
        const index: number = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    }

    /*// Radar
    public radarChartLabels: string[] = [
        'Eating',
        'Drinking',
        'Sleeping',
        'Designing',
        'Coding',
        'Cycling',
        'Running'
    ];
    public radarChartData: any = [
        { data: [65, 59, 90, 81, 56, 55, 40], label: 'Series A' },
        { data: [28, 48, 40, 19, 96, 27, 100], label: 'Series B' }
    ];
    public radarChartType: string = 'radar';*/

    // Pie
/*    public pieChartLabels: string[] = [
        'IT',
        'Service Delivery',
        'QA',
        'Support'
    ];
    public pieChartData: number[] = [185, 1, 35, 45];*/


    /*// PolarArea
    public polarAreaChartLabels: string[] = [
        'Download Sales',
        'In-Store Sales',
        'Mail Sales',
        'Telesales',
        'Corporate Sales'
    ];
    public polarAreaChartData: number[] = [300, 500, 100, 40, 120];
    public polarAreaLegend: boolean = true;

    public polarAreaChartType: string = 'polarArea';

    // lineChart
    public lineChartData: Array<any> = [
        { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
        { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' },
        { data: [18, 48, 77, 9, 100, 27, 40], label: 'Series C' }
    ];
    public lineChartLabels: Array<any> = [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July'
    ];
    public lineChartOptions: any = {
        responsive: true
    };
    public lineChartColors: Array<any> = [
        {
            // grey
            backgroundColor: 'rgba(148,159,177,0.2)',
            borderColor: 'rgba(148,159,177,1)',
            pointBackgroundColor: 'rgba(148,159,177,1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(148,159,177,0.8)'
        },
        {
            // dark grey
            backgroundColor: 'rgba(77,83,96,0.2)',
            borderColor: 'rgba(77,83,96,1)',
            pointBackgroundColor: 'rgba(77,83,96,1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(77,83,96,1)'
        },
        {
            // grey
            backgroundColor: 'rgba(148,159,177,0.2)',
            borderColor: 'rgba(148,159,177,1)',
            pointBackgroundColor: 'rgba(148,159,177,1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(148,159,177,0.8)'
        }
    ];
    public lineChartLegend: boolean = true;
    public lineChartType: string = 'line';*/

    // events
    public chartClicked(e: any): void {
        // console.log(e);
    }

    public chartHovered(e: any): void {
        // console.log(e);
    }

    /*public randomize(): void {
        // Only Change 3 values
        const data = [
            Math.round(Math.random() * 100),
            59,
            80,
            Math.random() * 100,
            56,
            Math.random() * 100,
            40
        ];
        const clone = JSON.parse(JSON.stringify(this.barChartData));
        clone[0].data = data;
        this.barChartData = clone;
        /**
         * (My guess), for Angular to recognize the change in the dataset
         * it has to change the dataset variable directly,
         * so one way around it, is to clone the data, change it and then
         * assign it;
         */
   /* }*/
    
}
