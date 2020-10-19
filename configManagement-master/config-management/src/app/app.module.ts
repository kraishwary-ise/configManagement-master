import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AuthGuard } from './auth/auth.guard';
import { ViewusecaseComponent } from './viewusecase/viewusecase.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddusecaseComponent } from './addusecase/addusecase.component';
import { ErrorComponent } from './error/error.component';
import { LogOutComponent } from './log-out/log-out.component';
import { TriggerComponent } from './trigger/trigger.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { OffersComponent } from './offers/offers.component'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbModalBackdrop } from '@ng-bootstrap/ng-bootstrap/modal/modal-backdrop';
import { SelectionComponent } from './selection/selection.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewusecaseComponent,
    NavbarComponent,
    AddusecaseComponent,
    ErrorComponent,
    LogOutComponent,
    TriggerComponent,
    OffersComponent,
    SelectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    DragDropModule,
    NgbModule,
    NgxPaginationModule,
    Ng2SearchPipeModule



  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
